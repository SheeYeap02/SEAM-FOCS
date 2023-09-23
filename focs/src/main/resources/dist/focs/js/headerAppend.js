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
            
            // Replace its innerHTML with the fetched headerHTML
            if (headerElement) {
                headerElement.innerHTML = headerHTML;
            }
        })
        .catch(error => console.error('Error fetching header.html:', error));
});

document.addEventListener("DOMContentLoaded", function() {
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