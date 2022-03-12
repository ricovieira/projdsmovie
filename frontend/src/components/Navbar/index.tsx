import { ReactComponent as GithubIcon } from 'assets/img/git.svg';
import './styles.css';

function Navbar(){
    return(
        <header>
    <nav className="container">
        <div className="dsmovie-nav-content">
            <h1>Projeto DSMovie</h1>
            <a href="https://github.com/ricovieira" target="_blank" rel="noreferrer">
                <div className="dsmovie-contact-container">
                    <GithubIcon />
                    <p className="dsmovie-contact-link">/ricovieira</p>
                </div>
            </a>
        </div>
    </nav>
</header>
    );
}

export default Navbar;