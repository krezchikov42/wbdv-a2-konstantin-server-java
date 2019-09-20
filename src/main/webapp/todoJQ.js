(function() {
	var titleFld;
	var descriptionFld;
	var addBtn;
	var todosUl;

	$(init);

	function init() {
		titleFld = $("#title");
		descriptionFld = $("#description");
		addBtn = $("#addBtn");
		todosUl = $("#todos");
		addBtn.click(addBtnHandler);
		fetch("https://wbdv-generic-server.herokuapp.com/api/jannunzi/movies", {
			method: 'post',
			headers: {
				'content-type': 'application/json'
			},
			body: JSON.stringify({title: 'aliens'})
		})
		.then(response => console.log(response))
		fetch("https://wbdv-generic-server.herokuapp.com/api/jannunzi/movies", response => console.log(response))
	}

	function addBtnHandler() {
		  var titleStr = titleFld.val();
		  var descriptionStr = descriptionFld.val();
		  var id = (new Date()).getTime();
		  var span = $("<span>X<span>")
		              .click(deleteNote);
		  var note = $("<li>")
		    .append(titleStr)
		    .append(span);
		  todosUl.append(note);
	}

	// todosUl
	//   .sortable()
	//   .draggable();


})()