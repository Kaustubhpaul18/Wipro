CREATE OR REPLACE PROCEDURE get_net_salary (
    p_empno     IN  emp.empno%TYPE,
    p_ename     OUT emp.ename%TYPE,
    p_net_sal   OUT NUMBER
) AS
    v_sal       emp.sal%TYPE;
    v_comm      emp.comm%TYPE;
    v_gross     NUMBER;
    v_it        NUMBER;
BEGIN
    -- Get salary and commission
    SELECT ename, sal, NVL(comm, 0) 
    INTO p_ename, v_sal, v_comm
    FROM emp
    WHERE empno = p_empno;

    -- Calculate Gross Salary
    v_gross := v_sal + v_comm;

    -- Calculate IT
    IF v_comm = 0 THEN
        v_it := 0.10 * v_gross;
    ELSIF v_comm < 500 THEN
        v_it := 0.15 * v_gross;
    ELSE
        v_it := 0.20 * v_gross;
    END IF;

    -- Net Salary
    p_net_sal := v_gross - v_it;
END;
/
