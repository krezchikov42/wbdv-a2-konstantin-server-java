(function() {

    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    var $searchBtn, $addBtn, $checkBtn;
    var userService = new AdminUserServiceClient();
    var current_user_selected;

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
        $checkBtn = $('.wbdv-update')[0]
        $checkBtn.addEventListener('click', updateUser);

        findAllUsers()

    }

    // handles create user event when user clicks on plus icon. Reads from the form elements and creates a user object.
    //  Uses the user service createUser() function to create the new user. Updates the list of users on server response
    function createUser() {
        let user = getUserFromForm()
        userService.createUser(user, () => findAllUsers())
        clearForms()
    }

    //creates a user from the current information in the forms
    function getUserFromForm() {
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
        return user
    }

    // called whenever the list of users needs to be refreshed. Uses user service findAllUsers() to retrieve all the users 
    // and passes response to renderUsers
    function findAllUsers() {
        userService.findAllUsers(user_many => renderUsers(user_many))
    }

    // called whenever a particular user needs to be retrieved by their id, as in when a user is selected for editing.
    //   Uses user service findUserById()
    //   to retrieve user and then updates the form on server response
    function findUserById(user_id) {
        userService.findUserById(user_id)
    }

    // handles delete user event when user clicks the cross icon. 
    //  Uses user service deleteUser() to send a delete request to the server. Updates user list on server response
    function deleteUser(user) {
        userService.deleteUser(user.id, findAllUsers)
    }

    function selectUser(user) {
        findUserById(user.id)
        $usernameFld.value = user.username
        $passwordFld.value = user.password
        $firstNameFld.value = user.first_name
        $lastNameFld.value = user.last_name
        $roleFld.value = user.role
        current_user_selected = user
    }

    // handles update user event when user clicks on check mark icon. 
    //  Reads new user values form the form, creates a user object and then uses user service updateUser()
    //   to send the new user data to server. Updates user list on server response
    function updateUser() {
        if (current_user_selected) {
            let user_form = getUserFromForm()
            let user_id = current_user_selected.id
            userService.updateUser(user_id, user_form, findAllUsers)
            clearForms()
            current_user_selected = null;
        }
    }

    // accepts a user object as parameter and updates the form with the user propertie
    function renderUser(user) {
        const rowClone = $userRowTemplate.clone();
        rowClone.removeClass("wbdv-hidden");
        rowClone.find('.wbdv-username').html(user.username);
        rowClone.find('.wbdv-password').html(user.password);
        rowClone.find('.wbdv-first-name').html(user.first_name);
        rowClone.find('.wbdv-last-name').html(user.last_name);
        rowClone.find('.wbdv-role').html(user.role)
        let $removeBtn = rowClone.find('.wbdv-remove');
        $removeBtn.click(event => deleteUser(user))
        let $editButton = rowClone.find('.wbdv-edit')
        $editButton.click(event => selectUser(user))
        $tbody.append(rowClone)
    }


    //resets forms and selected user
    function clearForms() {
        $usernameFld.value = ""
        $passwordFld.value = ""
        $firstNameFld.value = ""
        $lastNameFld.value = ""
        $roleFld.value = ""
        current_user_selected = null;
    }

    // accepts an array of user instances, clears the current content of the table body, iterates over the array of users,
    //  clones a table row template for each user instance, populates the table row with the user object properties, adds
    // the table row to the table body

    function renderUsers(user_many) {
        $('.wbdv-template').remove();
        for (var user_num in user_many) {
            user_one = user_many[user_num]
            renderUser(user_one)
        }
    }
})()