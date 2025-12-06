
$(document).ready(function () {
    
    $(".directory").each(function(){
        let id = $(this).attr('id');
        let count = $(this).attr('data-count');
        load_grid_for_directories("#" + id, count);
    });
    if (type == 'all') {
        $(document.body).on('click', '.nav-link', function (e) {
            e.preventDefault();
            let id = $(this).attr('data-id');
            $(".directory").each(function(){
                $(this).parent().hide();
            });
            $(".nav-link").each(function(){
                $(this).parent().removeClass('active');
            });
            $('#' + id).show();
            $(this).parent().addClass('active');
        });
    }
});

function load_grid_for_directories(id_name, count) {
    const media_1920 = window.matchMedia("(min-width: 1141px)");
    media_1920.addEventListener("change", (e)=>{
        if (e.matches == undefined) {
            e.matches = window.innerWidth > 1140;
        }
        if (e.matches) { 
            const new_count = Math.ceil(count/4);
            $(id_name).css({"grid-template-rows": `repeat(${new_count}, auto)`});
        }
    });
    media_1920.dispatchEvent(new Event('change'));

    const media_1140 = window.matchMedia("(max-width: 1140px) and (min-width: 992px)");
    media_1140.addEventListener("change", (e)=>{
        if (e.matches == undefined) {
            e.matches = window.innerWidth <= 1140;
        }
        if (e.matches) { 
            const new_count = Math.ceil(count/3);
            $(id_name).css({"grid-template-rows": `repeat(${new_count}, auto)`});
        }
    });
    media_1140.dispatchEvent(new Event('change'));

    const media_991 = window.matchMedia("(max-width: 991px) and (min-width: 768px)");
    media_991.addEventListener("change", (e)=>{
        if (e.matches == undefined) {
            e.matches = window.innerWidth <= 991;
        }
        if (e.matches) { 
            const new_count = Math.ceil(count/2);
            $(id_name).css({"grid-template-rows": `repeat(${new_count}, auto)`});
        }
    });
    media_991.dispatchEvent(new Event('change'));

    const media_767 = window.matchMedia("(max-width: 767px)");
    media_767.addEventListener("change", (e)=>{
        if (e.matches == undefined) {
            e.matches = window.innerWidth <= 767;
        }
        if (e.matches) { 
            const new_count = Math.ceil(count);
            $(id_name).css({"grid-template-rows": `repeat(${new_count}, auto)`});
        }
    });
    media_767.dispatchEvent(new Event('change'));
}