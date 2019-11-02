(function (argument) {

	let $tbody;
	let $movieRowTemplate;
	let $movieTitleFld;
	let $createBtn;

	$(main);

	let movies = [
		{title: 'Avatar', id: '123'},
		{title: 'Titanic', id:'234'},
		{title: 'Terminator 2', id: '345'}
	]

	function main() {
		$tbody = $("tbody")
		$movieRowTemplate = $(".movieRowTemplate")
		// renderMovies(movies)
		$movieTitleFld = $(".wbdv-new-movie-title")
		$createBtn = $(".wbdv-create")
		$createBtn.click(createNewMovie)
		loadMovies()
	}
	
	//http://localhost:4000

	function loadMovies() {
		fetch("http://localhost:4000/api/jannunzi/themovies")
			.then(response => response.json())
			.then(renderMovies)
	}

	function createNewMovie() {
		const newTitle = $movieTitleFld.val();
		const newMovie = {
			title: newTitle,
			id: (Date.now()) + ''
		}
		fetch("http://localhost:4000/api/jannunzi/themovies", {
			method: 'post',
			body: JSON.stringify(newMovie),
			headers: {
				'content-type': 'application/json'
			}
		}).then(response => console.log(response))
		// movies.push(newMovie)
		// renderMovies(movies);
	}

	function renderMovies(movies) {

		$tbody.empty();

		for(var i=0; i<movies.length; i++) {
			$tr =  $movieRowTemplate.clone() //$("<tr>")
			$td = $tr.find(".wbdv-title")
			$td.html(movies[i].title)
			// $td = $("<td>")
			// $td.append(movies[i].title)
			// $tr.append($td)

			$removeMovie = $tr.find(".wbdv-remove-movie")
			$removeMovie.click(deleteMovie)
			$removeMovie.attr("id", movies[i].id)

			$tbody.append($tr)	
		}
	}

	function deleteMovie(event) {
		const deleteButton = $(event.currentTarget)
		// const td = deleteButton.parent();
		// const tr = td.parent()
		// console.log(tr)
		// tr.remove();
		console.log(deleteButton.attr("id"))
		const movieIdToDelete = deleteButton.attr("id")

		fetch("http://localhost:4000/api/jannunzi/themovies/" + movieIdToDelete, {
			method: 'delete'})
		.then(loadMovies)
		// console.log(movies)
		// movies = movies.filter(function(movie) {
		// 	return movie.id != movieIdToDelete
		// })
		// console.log(movies)
		// renderMovies(movies);
	}
})();