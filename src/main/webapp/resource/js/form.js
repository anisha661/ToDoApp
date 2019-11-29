$(document).on('change', ':file', function () {
    var input = $(this),
        numFiles = input.get(0).files ? input.get(0).files.length : 1,
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.trigger('fileselect', [numFiles, label]);
});


$(document).ready(function () {
	
	   $("#create-post-button").prop("disabled", true);
	    $(".create-comment-button").prop("disabled", true);
	    var flag_file = 0;
	    var flag_text = 0;
$(':file').on('fileselect', function (event, numFiles, label) {
        var input = $(this).parents('.input-group').find(':text'),
            log = numFiles > 1 ? numFiles + ' files selected' : label;
        if (numFiles == 0) {
            if (input.length) {
                input.val(log);
            } else {
                if (log) alert(log);
            }
            flag_file = 0;
       
        } else {
            if (input.length) {
                input.val(log);
            } else {
                if (log) alert(log);
            }
            flag_file = 1;
            if ((flag_file + flag_text) == 2) {
             
            }
        }

    });

$("#post-text").keyup(function () {
    if ($("#post-text").val().length == 0) {
        flag_text = 0;
    }
    if ($("#post-text").val().length > 0) {
        flag_text = 1;
    }
    if ((flag_file + flag_text) == 2) {
        $("#create-post-button").prop("disabled", false);
    } else {
        $("#create-post-button").prop("disabled", true);
    }
    $("#characters-number").text(150 - $("#post-text").val().length);
});


});

$(document).ready(function(){
	var maxLength = 30;
	$(".show-read-more").each(function(){
		var myStr = $(this).text();
		if($.trim(myStr).length > maxLength){
			var newStr = myStr.substring(0, maxLength);
			var removedStr = myStr.substring(maxLength, $.trim(myStr).length);
			$(this).empty().html(newStr);
			$(this).append('...');
		}
	});
	$(".read-more").click(function(){
		$(this).siblings(".more-text").contents().unwrap();
		$(this).remove();
	});
});

