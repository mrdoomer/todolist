
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">


<!-- jscss/scripts.js -->
<style>
/* CSS for header */
header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 1000; /* Ensure header appears above the sidebar */
}

/* CSS for left sidebar */
.sidenav {
    position: fixed;
    top: 0;
    left: 0;
    width: 200px; /* Adjust width as needed */
    height: 100%; /* Ensure sidebar covers the entire height */
    background-color: #f8f9fa; /* Example background color */
    z-index: 999; /* Lower z-index to ensure it's behind the header */
}

/* CSS for body content */
.container {
    margin-left: 200px; /* Adjust margin to account for sidebar width */
    padding-top: 60px; /* Ensure content is below the header */
}

.sidenav h2 {
    text-align: center;
    margin-bottom: 30px;
    color: #333;
}

.sidenav ul {
    list-style-type: none;
    padding: 0;
}

.sidenav ul li {
    padding: 10px 20px;
}

.sidenav ul li a {
    text-decoration: none;
    color: #333;
    font-size: 18px;
    transition: color 0.3s;
}

.sidenav ul li a:hover {
    color: #007bff;
}

@media screen and (max-width: 768px) {
    .sidenav {
        width: 200px;
    }
}

  </style>
  
