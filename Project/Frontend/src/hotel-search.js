console.log('Hotel Search Page');

document.addEventListener('DOMContentLoaded', function () {
    const hotelResultsDiv = document.getElementById('hotel-results');

    // Function to fetch available hotels based on search criteria
    function fetchAvailableHotels(checkIn, checkOut, city) {
        const url = `http://localhost:8080/hotels/search?checkIn=${checkIn}&checkOut=${checkOut}&city=${city}`;

        fetch(url)
            .then(response => response.json())
            .then(data => {
                // Clear previous results
                hotelResultsDiv.innerHTML = '';

                // Display hotel results
                data.forEach(hotel => {
                    const hotelElement = document.createElement('div');
                    hotelElement.classList.add('hotel');
                    hotelElement.innerHTML = `
                        <h2>${hotel.name}</h2>
                        <p>Address: ${hotel.address}, ${hotel.city}, ${hotel.country}</p>
                        <p>Max Guests: ${hotel.maxGuests}</p>
                        <p>Price: ${hotel.price}</p>
                    `;
                    hotelResultsDiv.appendChild(hotelElement);
                });
            })
            .catch(error => console.error('Error fetching data:', error));
    }

    // Example usage:
    const checkInDate = '2024-04-17';
    const checkOutDate = '2024-04-19';
    const city = 'YourCityName'; // Replace with actual city name
    fetchAvailableHotels(checkInDate, checkOutDate, city);
});
