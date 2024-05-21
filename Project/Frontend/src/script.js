console.log("script.js loaded");

function displayUserDetails() {
    // Get the currently authenticated user
    var user = getAuthenticatedUser();

    // Get the user details element
    var userDetailsElement = document.getElementById('user-details');

    // If a user is logged in, display their details
    if (user) {
        userDetailsElement.innerHTML = `
            <h2>${user.firstName} ${user.lastName}</h2>
            <p>Username: ${user.username}</p>
            <p>Email: ${user.email}</p>
        `;
    } else {
        // If no user is logged in, display a message
        userDetailsElement.innerHTML = '<p>No user is currently logged in.</p>';
    }
}

function commonOnLoad() {

    function commonOnLoad() {
        // existing code...

        const jwt = getCookie('jwt'); // Assuming you have a function getCookie to get a cookie by name
        if (jwt) {
            document.getElementById('login-button').style.display = 'none'; // Hide login button
            document.getElementById('logout-button').style.display = 'block'; // Show logout button
        } else {
            document.getElementById('login-button').style.display = 'block'; // Show login button
            document.getElementById('logout-button').style.display = 'none'; // Hide logout button
        }
    }
        // Fetch navbar.html and insert its content into the navbar div
        fetch('./navbar.html')
            .then(response => response.text())
            .then(data => {
                const navbarDiv = document.getElementById('navbar');
                if (navbarDiv) {
                    navbarDiv.innerHTML = data;
                }
            });

        // Fetch footer.html and insert its content into the footer div
        fetch('./footer.html')
            .then(response => response.text())
            .then(data => {
                const footerDiv = document.getElementById('main-footer');
                if (footerDiv) {
                    footerDiv.innerHTML = data;
                }
            });

 // Initialize the dropdown menu for login
    var dropdownContent = document.querySelector('.dropdown-content');
    var dropbtn = document.querySelector('.dropbtn');
    var timeout;

    dropbtn.addEventListener('mouseover', function (event) {
        clearTimeout(timeout); // Clear the timeout if it's set
        dropdownContent.style.display = 'block';
    });

    dropbtn.addEventListener('mouseout', function (event) {
        // Set a timeout to hide the dropdown after 2 seconds
        timeout = setTimeout(function () {
            dropdownContent.style.display = 'none';
        }, 1000);
    });

    dropdownContent.addEventListener('mouseover', function (event) {
        clearTimeout(timeout); // Clear the timeout if it's set
        positionDropdown();
        dropdownContent.style.display = 'block';
    });

    dropdownContent.addEventListener('mouseout', function (event) {
        // Set a timeout to hide the dropdown after 2 seconds
        timeout = setTimeout(function () {
            dropdownContent.style.display = 'none';
        }, 1000);
    });

    // Function to position dropdown dynamically
    function positionDropdown() {
        var rect = dropbtn.getBoundingClientRect();
        var dropdownHeight = dropdownContent.offsetHeight;
        var dropdownWidth = dropdownContent.offsetWidth;

        // Calculate top position
        var top = rect.top + dropbtn.offsetHeight;
        if (top + dropdownHeight > window.innerHeight) {
            top = rect.top - dropdownHeight;
        }

        // Calculate left position
        var left = rect.left;
        if (left + dropdownWidth > window.innerWidth) {
            left = window.innerWidth - dropdownWidth;
        }

        // Set position of the dropdown content
        dropdownContent.style.top = top + 'px';
        dropdownContent.style.left = left + 'px';
    }

    document.querySelector('.logout-button').addEventListener('click', function(event) {
        // Prevent the button from being clicked normally
        event.preventDefault();

        // Log out the user
        doLogout();
    });

    document.querySelector('.login-form').addEventListener('submit', function(event) {
        // Prevent the form from being submitted normally
        event.preventDefault();

        // Get the entered username and password
        var username = document.querySelector('input[name="username"]').value;
        var password = document.querySelector('input[name="password"]').value;

        // Send the authentication request
        sendAuthenticationRequest(username, password, function() {
            // On success, call the commonOnLoad function to update the navbar
            commonOnLoad();
        }, function(error) {
            // On error, display an error message
            alert('Login failed: ' + error);
        });
    });

        const logoutButton = document.getElementById('logout-button');
        if (logoutButton) {
            logoutButton.addEventListener('click', function(event) {
                event.preventDefault(); // Prevent the default action

                doLogout();

            // Reload the page
            location.reload();
        });
    }
}
