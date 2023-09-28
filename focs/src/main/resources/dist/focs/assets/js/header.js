

//create header element and append to body
var header = document.createElement("header");
header.innerHTML = ` <header id="header" class="fixed-top d-flex align-items-center">
<div class="container d-flex align-items-center">

  <div class="logo me-auto">
    <h1><a href="homePage.html"><img src="https://www.tarc.edu.my/images/tarumt-logo1.png?v=beyongEducation2"
          alt="TAR UC" /></a></h1>
  </div>

  <nav id="navbar" class="navbar order-last order-lg-0">
    <ul>
      <li><a class="nav-link scrollto" href="homePage.html">Home</a></li>
      <li class="dropdown"><a href="#"><span>Programme</span> <i class="bi bi-chevron-down"></i></a>
        <ul>
          <li><a class="nav-link scrollto" href="programmes.html">All Programme</a></li>
          <li><a class="nav-link scrollto" href="programmes.html#searchProgramme">Diploma Programme</a></li>
          <li><a class="nav-link scrollto" href="programmes.html#searchProgramme">Bachelor Programme</a></li>
        </ul>
      </li>
      <li><a class="nav-link scrollto" href="aboutus.html">About Us</a></li>
      <li><a class="nav-link scrollto" href="staffDirectory.html">Our Team</a></li>
      <li><a class="nav-link scrollto" href="facility.html">Facilities</a></li>
      <li><a class="nav-link scrollto" href="submitEnquiry.html">Contact</a></li>
    </ul>
    <i class="bi bi-list mobile-nav-toggle"></i>
  </nav>

</div>
</header>`;

//append header to the first element in body
document.body.insertBefore(header, document.body.firstChild);
