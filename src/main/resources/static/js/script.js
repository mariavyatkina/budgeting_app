function getDescription() {
    var choice = document.querySelector('select').value;
    var p = document.querySelector("#description");
    if (choice == "Track Expenses/Investments/Income") {
        p.innerHTML = '<strong>Budgetting</strong> is a website made for convinient tracking of montly finances';
    } else if (choice == "Have a Summary of My Monthly Budget") {
        p.innerHTML = 'One of the great attributes of <strong>Budgetting</strong> is the Summary of Montly Finances which will provide information about your investments, income and expenses.';

    } else if (choice == "Be More Mindful of My Finances") {
        p.innerHTML = "<strong>Budgetting</strong>'s mission is to promote mindfulness of personal finances. Our goal is for you to be more aware of how and when you spend your money.";
    }
}

function validateSignIn() {
    var email;
    if (document.signInForm.email.value == "") {
        alert("Enter your Email");
        document.signInForm.email.focus;
        return false;
    } else {
        if (validateEmail(document.signInForm.email.value)) {
            email = document.signInForm.email.value;
        } else {
            return false;
        }
    }
    if (document.signInForm.password.value == "") {
        alert("Enter your password");
        document.signInForm.password.focus;
        return false;
    }

    alert("You signed in with " + email + " email address.");
}

function validateRegister() {
    if (document.registerForm.firstname.value == "") {
        alert("Enter your first name");
        document.registerForm.firstname.focus;
        return false;
    }
    if (document.registerForm.lastname.value == "") {
        alert("Enter your last name");
        document.registerForm.lastname.focus;
        return false;
    }
    if (document.registerForm.email.value == "") {
        alert("Enter your Email");
        document.registerForm.email.focus;
        return false;
    } else {
        if (validateEmail(document.registerForm.email.value)) {
            email = document.registerForm.email.value;
        } else {
            return false;
        }
    }
    if (document.registerForm.password.value == "") {
        alert("Enter your password");
        document.registerForm.password.focus;
        return false;
    }


}

function validateEmail(email) {
    atpos = email.indexOf("@");
    dotpos = email.lastIndexOf(".");
    if (atpos < 1 || (dotpos - atpos < 2)) {
        alert("Please enter correct email ID")
        return false;
    } else { return true; }
}

function changeColor() {
    var paragraphs = document.getElementsByTagName('p');
    var red = Math.floor((Math.random() * 256));
    var green = Math.floor((Math.random() * 256));
    var blue = Math.floor((Math.random() * 256));
    for (i in paragraphs) {
        paragraphs[i].style.color = 'rgb(' + red + "," + green + "," + blue + ")";
    }
}