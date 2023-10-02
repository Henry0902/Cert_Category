// --- Login, Register Validation ----
function checkEmail(value) {
    let invalidEmail = document.querySelector(".invalidEmail");
    if (value.length < 5 || value.length > 50) {
        invalidEmail.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        invalidEmail.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function checkUsername(value) {
    let invalidUsername = document.querySelector(".invalidUsername");
    if (value.length < 3 || value.length > 30) {
        invalidUsername.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        invalidUsername.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function checkPassword(value) {
    let invalidPassword = document.querySelector(".invalidPassword");
    if (value.length < 8 || value.length > 30) {
        invalidPassword.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        invalidPassword.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function checkRePassword(value) {
    let registerPassword = document.getElementById("registerPassword").value;
    let invalidRePassword = document.querySelector(".invalidRePassword");
    if (value != registerPassword) {
        invalidRePassword.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        invalidRePassword.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function loginOnSubmit() {
    let email = document.querySelector("#loginEmail").value;
    let password = document.querySelector("#loginPassword").value;

    if (checkEmail(email) && checkPassword(password)) {
        return true;
    } else {
        return false;
    }
}

function registerOnSubmit() {
    let username = document.querySelector("#registerUserName").value;
    let email = document.querySelector("#registerEmail").value;
    let password = document.querySelector("#registerPassword").value;
    let rePassword = document.querySelector("#registerRePassword").value;

    if (
        checkUsername(username) &&
        checkEmail(email) &&
        checkPassword(password) &&
        checkRePassword(rePassword)
    ) {
        alert("Register successfully!");
        return true;
    } else {
        return false;
    }
}

// --- Edit Profile Validation ----

function checkFirstName(value) {
    let invalidFirstName = document.querySelector("#firstNameInvalid");
    if (value.length < 3 || value.length > 30) {
        invalidFirstName.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        invalidFirstName.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function checkLastName(value) {
    let invalidLastName = document.querySelector("#lastNameInvalid");
    if (value.length < 3 || value.length > 30) {
        invalidLastName.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        invalidLastName.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function checkPhoneNumber(value) {
    let phoneValidate = /^\d{9,13}/;
    let phoneInvalid = document.querySelector("#phoneInvalid");
    if (!value.match(phoneValidate)) {
        phoneInvalid.style.setProperty("opacity", 1, "important");
        console.log("Phone abc");
        return false;
    } else {
        phoneInvalid.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function checkDescription(value) {
    let descriptionInvalid = document.querySelector("#descriptionInvalid");
    if (value.length > 200) {
        descriptionInvalid.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        descriptionInvalid.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function editProfileSubmit() {
    let firstName = document.querySelector("#firstNameInput").value;
    let lastName = document.querySelector("#lastNameInput").value;
    let phoneNumber = document.querySelector("#phoneNumberInput").value;
    let description = document.querySelector("#descriptionInvalid").value;

    if (
        checkFirstName(firstName) &&
        checkLastName(lastName) &&
        checkPhoneNumber(phoneNumber) &&
        checkDescription(description)
    ) {
        alert("Edit Profile successfully!");
        return true;
    } else {
        return false;
    }
}

// ---- Form Content Validation

function checkTitle(value) {
    let titleInvalid = document.querySelector("#titleInvalid");
    if (value.length < 10 || value.length > 200) {
        titleInvalid.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        titleInvalid.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function checkBrief(value) {
    let briefInvalid = document.querySelector("#briefInvalid");
    if (value.length < 30 || value.length > 150) {
        briefInvalid.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        briefInvalid.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function checkContent(value) {
    let contentInvalid = document.querySelector("#contentInvalid");
    if (value.length < 30 || value.length > 150) {
        contentInvalid.style.setProperty("opacity", 1, "important");
        return false;
    } else {
        contentInvalid.style.setProperty("opacity", 0, "important");
        return true;
    }
}

function addContentOnSubmit() {
    let title = document.querySelector("#titleInput").value;
    let brief = document.querySelector("#briefInput").value;
    let content = document.querySelector("#contentInput").value;

    if (
        checkTitle(title) &&
        checkBrief(brief) &&
        checkContent(content)
    ) {
        alert("Add Content successfully!");
        return true;
    } else {
        return false;
    }
}