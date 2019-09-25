function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = "https://wbdv-generic-server.herokuapp.com/api/001289771";
    var self = this;


    //accepts a user object and adds it to a collection of users
    function createUser(user, callback) {
        let url = this.url + "/users";
        fetch(url, {
                method: "POST",
                body: JSON.stringify(user),
                headers: {
                    "content-type": "application/json"
                }
            }).then(response => (response.json()))
            .then(parsedJson => callback(parsedJson))
    }

    //retrieves all users as an array of JSON objects
    function findAllUsers(callback) {
        let url = this.url + '/users';
        let promise = fetch(url, {
            method: 'GET',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json().then(parsedJson => callback(parsedJson)))
    }

    //retrieves a single user object whose id is equal to the id parameter
    function findUserById(userId, callback) {
        let url = this.url + '/users/' + userId;
        fetch(url, {
            method: 'GET',
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json().then(parsedJson => callback(parsedJson)))
    }

    //accepts a user id and user object with new property values for the user with user id.
    // Finds the user whose id matches he id parameter and updates it with the values in the user parameter
    function updateUser(userId, user, callback) {
        let url = this.url + '/users/' + userId;
        fetch(url, {
            method: 'PUT',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json().then(parsedJson => callback(parsedJson)))
    }

    //removes the user whose id matches the id parameter
    function deleteUser(userId, callback) {
        let url = this.url + '/users/' + userId;
        fetch(url, {
            method: 'DELETE',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(response => response.json().then(parsedJson => callback(parsedJson)))
    }
}