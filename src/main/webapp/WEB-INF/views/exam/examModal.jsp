<!-- Modal for question -->
<div id="questionModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Question</h4>
      </div>
      <div class="modal-body text-left">
	      <div class="form-group required">
	      	<label class="control-label" for="question">Question</label>
	      	<textarea cols="50" rows="1" class="form-control" id="question" name="question" placeholder="Edit Question" required="required"></textarea>
	      </div>
	      <div class="form-group required">
	      	<label class="control-label" for="option1">Option 1</label>
	      	<textarea cols="50" rows="1" class="form-control" id="option1" name="option1" placeholder="Edit Option 1" required="required"></textarea>
	      </div>
	      <div class="form-group required">
	      	<label class="control-label" for="option2">Option 2</label>
	      	<textarea cols="50" rows="1" class="form-control" id="option2" name="option2" placeholder="Edit Option 2" required="required"></textarea>
	      </div>
	      <div class="form-group required">
	      	<label class="control-label" for="option3">Option 3</label>
	      	<textarea cols="50" rows="1" class="form-control" id="option3" name="option3" placeholder="Edit Option 3" required="required"></textarea>
	      </div>
	      <div class="form-group required">
	      	<label class="control-label" for="option4">Option 4</label>
	      	<textarea cols="50" rows="1" class="form-control" id="option4" name="option4" placeholder="Edit Option 1" required="required"></textarea>
	      </div>
	      <div class="form-group required">
	      	<label class="control-label" for="correctAnswer">Correct Answer</label>
	      	<textarea cols="50" rows="1" class="form-control" id="correctAnswer" name="correctAnswer" placeholder="Edit Correct Answer" required="required"></textarea>
	      </div>
      </div>
      <div class="modal-footer">
	       <div class="col-md-6 col-md-offset-2">
	      	 <button id="deviateCommentsBtn" type="button" class="btn btn-default modalButton">Update</button>
	         <button type="button" class="btn btn-default modalButton" data-dismiss="modal">Cancel</button>
	        </div>
      </div>
    </div>
  </div>
</div>  
<!-- Modal for question end -->