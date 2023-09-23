// document.addEventListener("DOMContentLoaded", function() {
//     // Fetch the content of header.html
//     fetch('header.html')
//         .then(response => response.text())
//         .then(headerHTML => {
//             // Find the element with class "headerjs"
//             var headerElement = document.querySelector(".headerjs");

//             // Replace its innerHTML with the fetched headerHTML
//             if (headerElement) {
//                 headerElement.innerHTML = headerHTML;
//             }
//         })
//         .catch(error => console.error('Error fetching header.html:', error));
// });

document.addEventListener("DOMContentLoaded", function() {
    // Fetch the content of header.html
    fetch('header.html')
        .then(response => response.text())
        .then(headerHTML => {
            // Find the element with class "headerjs"
            var headerElement = document.querySelector(".headerjs");

            //headerHTML = headerHTML.replace(/127\.0\.0\.1/g, 'abc');

            // fetch('https://api.ipify.org/?format=json')
            //     .then(results => results.json())
            //     .then(data => {
            //         // const ipAddress = data.ip;
            //         // const replacedUserAgent = parts.map(part => part === '127.0.0.1' ? ipAddress : part).join('/');

            //         headerHTML = headerHTML.replace(/127\.0\.0\.1/g, data);

            //         // Now you can use `replacedUserAgent` as needed
            //         //console.log(replacedUserAgent);

            //         // If you want to update an HTML element with the modified user agent
            //         //document.getElementById('ipAdd').innerText = replacedUserAgent;

            //         // Replace its innerHTML with the fetched headerHTML
            //         if (headerElement) {
            //             headerElement.innerHTML = headerHTML;
            //         }
            //     })
            //     .catch(error => console.error('Error fetching IP address:', error));

            if (headerElement) {
                headerElement.innerHTML = headerHTML;
            }

        })
        .catch(error => console.error('Error fetching header.html:', error));
});

document.addEventListener("DOMContentLoaded", function () {
    // Fetch the content of header.html
    fetch('footer.html')
        .then(response => response.text())
        .then(headerHTML => {
            // Find the element with class "headerjs"
            var headerElement = document.querySelector(".footerjs");

            // Replace its innerHTML with the fetched headerHTML
            if (headerElement) {
                headerElement.innerHTML = headerHTML;
            }
        })
        .catch(error => console.error('Error fetching footer.html:', error));
});
