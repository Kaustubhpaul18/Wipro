// Display current date and time at top right
function updateDateTime() {
    let now = new Date();
    document.getElementById("dateTime").innerText = now.toLocaleString();
}
setInterval(updateDateTime, 1000);

// Timer: Alert if more than 3 minutes
setTimeout(() => {
    alert("3 minutes past! Please submit the form.");
}, 180000);

// Form Validation
function validateForm() {
    let fname = document.getElementById("fname").value.trim();
    let lname = document.getElementById("lname").value.trim();
    let pass = document.getElementById("password").value;
    let cpass = document.getElementById("cpassword").value;
    let mobile = document.getElementById("mobile").value.trim();
    let dob = document.getElementById("dob").value.trim();
    let email = document.getElementById("email").value.trim();
    let gender = document.querySelector('input[name="gender"]:checked');

    // First name validation
    if (fname === "" || !/^[A-Za-z]+$/.test(fname)) {
        alert("First name must be entered and must contain only characters.");
        return false;
    }

    // Last name validation
    if (lname === "" || !/^[A-Za-z]+$/.test(lname)) {
        alert("Last name must be entered and must contain only characters.");
        return false;
    }

    // Password validation
    if (pass.length < 6 || pass.length > 20) {
        alert("Password must be 6 to 20 characters long.");
        return false;
    }

    if (pass !== cpass) {
        alert("Password and Confirm Password must match.");
        return false;
    }

    // Gender validation
    if (!gender) {
        alert("Please select your gender.");
        return false;
    }

    // Mobile validation
    let mobilePattern = /^(\d{3}[-. ]\d{3}[-. ]\d{4})$/;
    if (!mobilePattern.test(mobile)) {
        alert("Mobile must be in format XXX-XXX-XXXX or XXX.XXX.XXXX or XXX XXX XXXX");
        return false;
    }

    // DOB validation
    let dobPattern = /^\d{2}-\d{2}-\d{4}$/;
    if (!dobPattern.test(dob)) {
        alert("DOB must be in DD-MM-YYYY format.");
        return false;
    }

    // Email validation
    let emailPattern = /^[^@][A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
    if (!emailPattern.test(email)) {
        alert("Enter a valid email address.");
        return false;
    }

    return true;
}
