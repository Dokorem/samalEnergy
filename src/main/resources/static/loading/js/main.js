const preloaderWrapper = document.querySelector('.preloader-wrapper');

window.addEventListener('load', function() {
    // Запускаем таймер на 3 секунды после загрузки страницы
    setTimeout(function() {
        // Добавляем класс для анимации исчезновения
        preloaderWrapper.classList.add('fade-out-animation');

        // Чтобы полностью удалить элемент из DOM или сделать его невидимым после анимации,
        // можно добавить обработчик события 'transitionend'.
        preloaderWrapper.addEventListener('transitionend', function() {
            preloaderWrapper.style.display = 'none';
        });
    }, 600); // 3000 миллисекунд = 3 секунды
});
