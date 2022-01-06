function processContactForm(e) {
  e.preventDefault();
  $("#contact-confirmation").show("slow");
  return false;
}

// Function to check Whether both passwords is same or not.
function checkPasswords(form) {
    password1 = form.password.value;
    password2 = form.password2.value;

    if (password1 != password2) {
        document.getElementById("invalidatedPasswords").innerHTML = "Passwords do not match! <br/>";
        return false;
    } else{
        return true;
    }
}

function validatePaymentForm() {
    let isValidated = true;
    const errorMessages = document.getElementById("errorMessages");
    errorMessages.innerHTML = "";
    if (!document.getElementById("discover").checked
            && !document.getElementById("master").checked
            && !document.getElementById("visa").checked) {
        errorMessages.innerHTML += "Please select a credit card type <br/>";
        isValidated = false;
    }
    if (document.getElementById("number").value == "") {
        errorMessages.innerHTML += "Please put in your credit card number <br/>";
        isValidated = false;
    }
    if (document.getElementById("expiration").value == "") {
        errorMessages.innerHTML += "Please put in your credit card's expiration date <br/>";
        isValidated = false;
    }

    return isValidated;
}

$(document).ready(function () {
    $(".moreBox").slice(0, 10).show();
    if ($(".bookBox:hidden").length != 0) {
        $("#loadMore").show();
    }
    $("#loadMore").on('click', function (e) {
        e.preventDefault();
        $(".moreBox:hidden").slice(0, 5).slideDown();
        if ($(".moreBox:hidden").length == 0) {
            $("#loadMore").fadeOut('slow');
        }
    });
});