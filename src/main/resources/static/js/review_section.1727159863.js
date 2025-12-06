document.addEventListener("DOMContentLoaded", () => {
    initCustomScrollbar(document.querySelector(".review-section-container .right-section .scroll-container"));
});

const initCustomScrollbar = (scrollContainerDOM) => {
    if (!scrollContainerDOM) return;

    let currentIndex = 0;
    const scrollControllerDOM = scrollContainerDOM.querySelector('.scroll-controller');

    const desktopArrowPrev = document.querySelector('.review-section-container .right-section .scroll-container .desktop-arrow.prev');
    
    const desktopArrowNext = document.querySelector('.review-section-container .right-section .scroll-container .desktop-arrow.next');

    const scrollDOM = scrollContainerDOM.querySelector('.scroll');
    const cardDOMArray = scrollDOM.querySelectorAll('.card');

    if (scrollDOM.clientWidth >= (scrollDOM.scrollWidth - 1)) {
        scrollDOM.classList.add('no-scroll');
        return;
    }

    scrollControllerDOM.style.display = 'flex';

    const scrollbarThumbDOM = scrollControllerDOM.querySelector('.track .thumb');

    scrollbarThumbDOM.style.width = `${(scrollDOM.clientWidth * 100) / scrollDOM.scrollWidth}%`;

    scrollDOM.addEventListener('scroll', e => {
        scrollControllerDOM.querySelector('.track .thumb').style.left = `${(scrollDOM.scrollLeft * 100) / scrollDOM.scrollWidth}%`;

        if (scrollDOM.scrollLeft === 0) {
            scrollControllerDOM.querySelector('.arrow.prev').classList.add('disabled');
            desktopArrowPrev.classList.add('disabled');
        } else if (scrollDOM.scrollLeft + scrollDOM.clientWidth >= (scrollDOM.scrollWidth - 1)) {
            scrollControllerDOM.querySelector('.arrow.next').classList.add('disabled');
            desktopArrowNext.classList.add('disabled');
        } else {
            desktopArrowNext.classList.remove('disabled');
            desktopArrowPrev.classList.remove('disabled');
            scrollControllerDOM.querySelector('.arrow.prev').classList.remove('disabled');
            scrollControllerDOM.querySelector('.arrow.next').classList.remove('disabled');
        }
    });

    scrollControllerDOM.querySelector('.arrow.next').addEventListener('click', e => {
        if (e.currentTarget.classList.contains('disabled')) return;

        if (cardDOMArray[currentIndex + 1]) {
            currentIndex++;
            cardDOMArray[currentIndex].scrollIntoView({ behavior: "smooth", block: 'nearest', inline: 'start'});
        } else {
            cardDOMArray[cardDOMArray.length - 1].scrollIntoView({ behavior: "smooth", block: 'nearest', inline: 'start'});
        }
    });

    scrollControllerDOM.querySelector('.arrow.prev').addEventListener('click', e => {
        if (e.currentTarget.classList.contains('disabled')) return;

        if (cardDOMArray[currentIndex - 1]) {
            currentIndex--;
            cardDOMArray[currentIndex].scrollIntoView({ behavior: "smooth", block: 'nearest', inline: 'start'});
        } else {
            cardDOMArray[0].scrollIntoView({ behavior: "smooth", block: 'nearest', inline: 'start'});
        }
    });

    const resetScrollPosition = () => {
        currentIndex = 0;
        cardDOMArray[0].scrollIntoView({ block: 'nearest', inline: 'start' });
    }

    return resetScrollPosition;
}
