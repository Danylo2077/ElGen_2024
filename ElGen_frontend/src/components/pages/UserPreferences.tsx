import React from 'react'
import './styles/UserPreferences.css';
import Title from '../atoms/Title';
import Header from '../atoms/Header';
import Button from '../atoms/Button';
import TagsSlider from '../organism/TagsSlider';
import IconBlock from '../moleculs/IconBlock';
import UserProfile from '../moleculs/UserProfile';
const UserPreferences = () => {
  return (
    <div className='user-preferences'>
      <IconBlock iconName='profileIcon' iconSource=' ' text='User' titleName='username' wrapperName='profileWrapper'/>
      <UserProfile/>  
      <Button text='skip' btnName='skip'/>
      <Title text='Calibrating your taste'/>
      <TagsSlider/>
      <Header header='Select Themes You Love' subheader='You should choose at least 3 themes to set up your recommendation'/>
      <Button btnName='continue-btn' text='Continue'/>
    </div>
  )
}

export default UserPreferences
