// LBS_Func.Generaljs
document.addEventListener('DOMContentLoaded', function () {
    // Xử lý collapsible section
    const toggle = document.getElementById('collapsible3');
    if (toggle) {
        toggle.addEventListener('change', function () {
            const content = document.querySelector('.collapsible-content');
            if (this.checked) {
                content.style.display = 'block';
            } else {
                content.style.display = 'none';
            }
        });
    }
});