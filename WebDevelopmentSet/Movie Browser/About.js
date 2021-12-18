import Hero from "./Hero";
const AboutView = () => {
    return (
        <>
        <Hero name = "About Us" />
        <h2> About us</h2>
        <div className="container">
        <div className="row">
          <div className="col-lg-8 offset-lg-2 my-5">
            <p className="lead">
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
              enim ad minim veniam, quis nostrud exercitation ullamco laboris
            </p>
          </div>
        </div>
      </div>

        </>
    )
}

export default AboutView;