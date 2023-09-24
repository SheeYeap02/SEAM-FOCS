//create footer element and append to body
var footer = document.createElement("footer");

footer.innerHTML = `   <footer id="footer">
<div class="footer-top">
  <div class="container">
    <div class="row">

      <div class="col-lg-3 col-md-6">
        <img src="img/footer1.jpg" class="img-fluid" alt="">
      </div>

      <div class="col-lg-3 col-md-6">
        <div class="footer-info">
          <h3>Address</h3>
          <p><strong>Faculty of Computing and Information Technology</strong> <br>
            Tunku Abdul Rahman University of Management and Technology <br>
            Jalan Genting Kelang, Setapak <br>
            53300 Kuala Lumpur <br>
            Malaysia <br><br>
          </p>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 footer-links">
        <h4>Our Contact</h4>
        <ul>
          <li><strong>Phone: </strong> 603-41450123 Ext no. 3233</li>
          <li><strong>Phone: </strong> <a class="text-primary-hover"
              href="mailto:contact@sampledomain.com">603-41423166 / 018 925 1001</a></li>
          <li><strong>Email: </strong> <a class="text-primary-hover"
              href="mailto:focs@tarc.edu.my">focs@tarc.edu.my</a></li>
          <li><strong>Your IP Address: </strong> 127.0.0.1</li>
        </ul>
      </div>

      <div class="col-lg-3 col-md-6 footer-links">
        <div class="footer-info">
          <h3>Where We Are?</h3>
          <iframe
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3983.53781216072!2d101.72217973488769!3d3.2152552000000023!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31cc3843bfb6a031%3A0x2dc5e067aae3ab84!2sTunku%20Abdul%20Rahman%20University%20of%20Management%20and%20Technology%20(TAR%20UMT)!5e0!3m2!1sen!2smy!4v1694823435275!5m2!1sen!2smy"
            frameborder="0" style="border:0; width: 100%; height: 270px;" allowfullscreen></iframe>
        </div>
      </div>

    </div>
  </div>
</div>

<div class="container">
  <div class="copyright">
    TAR UMT © 2023 All Rights Reserved Disclaimer Privacy Policy and ABAC Policy
  </div>
</div>
</footer>`;


const parts = navigator.userAgent.split('/');

let ipInfo = '';
ipInfo += parts[0] + ' : ';
fetch('https://api.ipify.org/?format=json')
  .then(results => results.json())
  .then(data => {
    ipInfo += data.ip;
    footer.innerHTML = footer.innerHTML.replace(/127\.0\.0\.1/g, ipInfo);
    //append footer to the last element in body
    document.body.appendChild(footer);

  })
  .catch(error => {
    // Replace its innerHTML with the fetched headerHTML
    ipInfo += 'NA';
    footer.innerHTML = footer.innerHTML.replace(/127\.0\.0\.1/g, ipInfo);
    console.error('Error fetching IP address:', error);
    //append footer to the last element in body
    document.body.appendChild(footer);
  });





