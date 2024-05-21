// Scripts related to the profile page

runOnLoad(loadProfileData);

const profileSaveButton = document.getElementById("profile-save-button");
const emailElement = document.getElementById("email");

profileSaveButton.onclick = function (event) {
    event.preventDefault(); // Don't submit the form
    const profileData = {
        "email": emailElement.value
    };
    const username = getCookie("current_username");
    emailElement.disabled = true;
    profileSaveButton.disabled = true;
    sendApiRequest("PUT", "/users/" + username, profileSaveSuccess, profileData, profileSaveError);
}

/**
 * Send request to backend, load user profile data
 */
function loadProfileData() {
    console.log("Loading profile data from API...");
    emailElement.disabled = true;
    profileSaveButton.disabled = true;
    const user = getAuthenticatedUser();
    if (user) {
        sendApiRequest("GET", "/users/" + user.username, showProfileData);
    } else {
        redirectTo("/no-access.html");
    }
}

/**
 * Show user profile data on the page
 * @param profileData User profile data received from the backend
 */
function showProfileData(profileData) {
    if (profileData) {
        emailElement.innerText = profileData.bio ? profileData.bio : "";
        emailElement.disabled = false;
        profileSaveButton.disabled = false;
    }
}

/**
 * This function is called when profile was successfully saved (response from API received)
 */
function profileSaveSuccess() {
    showFormSuccess("Profile saved");
    emailElement.disabled = false;
    profileSaveButton.disabled = false;
}

/**
 * This function is called when profile-saving failed
 * @param error Error message received from the API
 */
function profileSaveError(error) {
    showFormError(error);
}