// LBS_Valid.Generaljs
document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form');
    if (form) {
        form.addEventListener('submit', function (e) {
            const id = document.querySelector('input[name="id"]').value;
            const firstName = document.querySelector('input[name="firstName"]').value;
            const lastName = document.querySelector('input[name="lastName"]').value;

            if (!id || !firstName || !lastName) {
                e.preventDefault();
                alert('Please fill in all required fields (ID, First Name, Last Name).');
            }
        });
    }
});