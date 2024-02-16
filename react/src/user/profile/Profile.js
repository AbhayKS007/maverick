import React, { Component } from 'react';
import './Profile.css';

class Profile extends Component {
    constructor(props) {
        super(props);
        console.log(props);
    }
    render() {
        return (
            <div className="profile-container">
                <div className="container">
                    <div className="profile-info">
                        <div className="profile-avatar">
                            {
                                (
                                    <div className="text-avatar">
                                        <span>{this.props.currentUser.name && this.props.currentUser.firstName[0]}</span>
                                    </div>
                                )
                            }
                        </div>
                        <div className="profile-name">
                            <h2>Name: {this.props.currentUser.firstName}</h2>
                            <p className="profile-email">Email: {this.props.currentUser.email}</p>
                            <p className="profile-email">Account Balance: {this.props.currentUser.account.balance.amount}</p>
                            <table>
                                <thead>
                                    <tr>
                                        <th>Ref Number</th>
                                        <th>Date</th>
                                        <th>Withdrawal</th>
                                        <th>Deposit</th>
                                        <th>Closing Balance</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                        <tr >
                                            <td>{this.props.currentUser.account.transaction.transactionId}</td>
                                            <td>{this.props.currentUser.account.transaction.createdAt}</td>
                                            <td>{this.props.currentUser.account.transaction.withdrawal}</td>
                                            <td>{this.props.currentUser.account.transaction.amount}</td>
                                            <td>{this.props.currentUser.account.balance.account}</td>
                                        </tr>
                                   
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Profile