function showForm(formId) {
    // Hide all form sections
    var forms = document.getElementsByClassName('form-section');
    for (var i = 0; i < forms.length; i++) {
        forms[i].classList.remove('active');
    }

    // Show the selected form section
    document.getElementById(formId).classList.add('active');

    // Remove active class from all buttons
    var buttons = document.querySelectorAll('.tabs button');
    buttons.forEach(button => button.classList.remove('active'));

    // Add active class to the clicked button
    document.getElementById(formId + 'Btn').classList.add('active');