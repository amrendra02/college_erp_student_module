import React from 'react';
import './header.css';

const Header = ({ data }) => {
   return (

      <div className="Head">

         <div className="Dashboard">{data}</div>

         <div className="Rectangle3">
            <div className="CircumSearch">
            </div>
            <input className="Search" placeholder='seacrh' type='text' />
         </div>

         <div className="MingcuteNotificationFill"></div>

         <div className="IconamoonProfileCircleThin" />
      </div>

   )
}

export default Header
