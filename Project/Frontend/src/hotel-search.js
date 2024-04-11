console.log("hotel-search.js loaded");

// Function to parse URL parameters
function getUrlParams() {
    var params = new URLSearchParams(window.location.search);
    return params;
}

// Function to display form data
function displayFormData() {
    var params = getUrlParams();

    var cityPreference = params.get('destination_preference');
    var checkinDate = params.get('checkin');
    var checkoutDate = params.get('checkout');
    var roomPreference = params.get('room_preference');
    var totalGuests = params.get('total_guests');

    var resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = `
                <p>City: ${cityPreference}</p>
                <p>Check-In Date: ${checkinDate}</p>
                <p>Check-Out Date: ${checkoutDate}</p>
                <p>Total Guests: ${totalGuests}</p>
            `;
}

// Call the displayFormData function when the page loads
window.onload = displayFormData;