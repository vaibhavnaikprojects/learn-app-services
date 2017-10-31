$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    $('.datatable').DataTable({
    		iDisplayLength : 5,
	});
});

function navigation(page){
	location.href=page;
}

function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imagePreview').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#slideImage").change(function(){
    readURL(this);
});

function aud_play_pause(audioId) {
  var myAudio = document.getElementById("audio"+audioId);
  if (myAudio.paused) {
    $('#stateicon'+audioId).removeClass('glyphicon glyphicon-play');
    $('#stateicon'+audioId).addClass('glyphicon glyphicon-pause');
    myAudio.play();
  } else {
    $('#stateicon'+audioId).removeClass('glyphicon glyphicon-pause');
    $('#stateicon'+audioId).addClass('glyphicon glyphicon-play');
    myAudio.pause();
 }
  myAudio.addEventListener("ended", function() 
		     {
	  	$('#stateicon'+audioId).removeClass('glyphicon glyphicon-pause');
	    $('#stateicon'+audioId).addClass('glyphicon glyphicon-play');
		     });
}