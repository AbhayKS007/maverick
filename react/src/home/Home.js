import React, { Component } from 'react';
import './Home.css';
import companyLogo from '../img/logo.png';

class Home extends Component {
    render() {
        return (
            <div className="home-container">
                <div className="container">
                    <div className="graf-bg-container">
                        <div>
                        <img src={companyLogo} alt="Maveric logo"/>
                        </div>
                    </div>
                    <h1 className="home-title">Maveric Bank enabling bank customers</h1>
                </div>
            </div>
        )
    }
}

export default Home;