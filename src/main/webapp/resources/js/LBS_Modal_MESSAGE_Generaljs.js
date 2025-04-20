// LBS_Modal_MESSAGE.Generaljs
function showMessage(message) {
    const modal = document.createElement('div');
    modal.className = 'modal';
    modal.innerHTML = `
        <div class="modal-content">
            <span class="close">&times;</span>
            <p>${message}</p>
        </div>
    `;
    document.body.appendChild(modal);

    const closeBtn = modal.querySelector('.close');
    closeBtn.onclick = function () {
        modal.remove();
    };

    modal.style.display = 'block';
}