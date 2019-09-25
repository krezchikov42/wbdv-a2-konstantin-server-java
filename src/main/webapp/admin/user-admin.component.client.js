(function() {
    // import AdminUserServiceClient from './user.service.client'; // or './module'

    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var $searchBtn, $addBtn, $checkBtn;
    var userService = new AdminUserServiceClient();
    // const users = [1, 2, 3, 4, 5, 6]
    const user_a = { 'username': 'a', 'password': '***', 'first_name': 'b', 'last_name': 'l', 'role': 'Faculty' }
        // const users = [{ 'username': 'a', 'password': '***', 'first': 'b', 'last': 'l' }]
    $(main);

    // executes on document load, when the browser is done parsing the html page and the dom is ready.
    //  Retrieved the dom elements needed later in the component such as the form elements, action icons, and templates.
    //   Binds action icons, such as create, update, select, and delete, to respective event handlers
    function main() {
        $userRowTemplate = $('.wbdv-template');
        $usernameFld = $('#usernameFld')[0];
        $passwordFld = $('#passwordFld')[0];
        $firstNameFld = $('#firstNameFld')[0];
        $lastNameFld = $('#lastNameFld')[0];
        $roleFld = $('#roleFld')[0];
        $addBtn = $('.wbdv-create')[0];
        $tbody = $('tbody')
        $addBtn.addEventListener('click', createUser);

        findAllUsers()

    }

    // handles create user event when user clicks on plus icon. Reads from the form elements and creates a user object.
    //  Uses the user service createUser() function to create the new user. Updates the list of users on server response
    function createUser() {
        let username = $usernameFld.value;
        let password = $passwordFld.value;
        let firstName = $firstNameFld.value;
        let lastName = $lastNameFld.value;
        let role = $roleFld.value;

        let user = {
            "username": username,
            "password": password,
            "first_name": firstName,
            "last_name": lastName,
            "role": role
        };
        console.log(user)

        userService.createUser(user)
        renderUser(user)
    }

    // called whenever the list of users needs to be refreshed. Uses user service findAllUsers() to retrieve all the users 
    // and passes response to renderUsers
    function findAllUsers() {
        userService.findAllUsers(user_many => renderUsers(user_many))
    }

    // called whenever a particular user needs to be retrieved by their id, as in when a user is selected for editing.
    //  Reads the user id from the icon id attribute. Uses user service findUserById()
    //   to retrieve user and then updates the form on server response
    function findUserById(user_id) {
        userService.findUserById(user_id)
    }

    // handles delete user event when user clicks the cross icon. Reads the user id from the icon id attribute.
    //  Uses user service deleteUser() to send a delete request to the server. Updates user list on server response
    function deleteUser(user) {
        console.log('delete', user)
        userService.deleteUser(user.id)
        deleteRow(user_id)
    }

    function deleteRow(user_id) {
        let $row = $(user_id + '_row');
        $row.remove()
    }

    // function selectUser() {…}

    // // handles update user event when user clicks on check mark icon. Reads the user id from the icon id attribute.
    // //  Reads new user values form the form, creates a user object and then uses user service updateUser()
    // //   to send the new user data to server. Updates user list on server response
    // function updateUser() {…}

    // accepts a user object as parameter and updates the form with the user propertie
    function renderUser(user) {
        const rowClone = $userRowTemplate.clone();
        rowClone.find('.wbdv-username').html(user.username);
        rowClone.find('.wbdv-password').html(user.password);
        rowClone.find('.wbdv-first-name').html(user.first_name);
        rowClone.find('.wbdv-last-name').html(user.last_name);
        rowClone.find('.wbdv-role').html(user.role)
        let $removeBtn = rowClone.find('.wbdv-remove');
        $removeBtn.click(event => deleteUser(user))
        let $editButton = rowClone.find('.wbdv-edit')
        $editButton.click(event => selectUser(user))
            // rowClone.
        $tbody.append(rowClone)
    }


    // accepts an array of user instances, clears the current content of the table body, iterates over the array of users,
    //  clones a table row template for each user instance, populates the table row with the user object properties, adds
    // the table row to the table body

    function renderUsers(user_many) {
        $('wbdv-template').remove();
        for (var user_num in user_many) {
            user_one = user_many[user_num]
            renderUser(user_one)
        }
    }
})()