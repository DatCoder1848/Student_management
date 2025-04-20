// OamUserJs.Generaljs
document.addEventListener('DOMContentLoaded', function () {
    const buttons = document.querySelectorAll('.btn');
    buttons.forEach(button => {
        button.addEventListener('click', function () {
            const action = this.getAttribute('value');
            console.log(`Action: ${action}`);
            // Thêm logic để gửi yêu cầu đến backend (AJAX hoặc submit form)
        });
    });
});