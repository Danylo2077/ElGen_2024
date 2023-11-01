import React from 'react'
import './styles/UserPreferences.css';
import Title from '../atoms/Title';
import Header from '../atoms/Header';
import Button from '../atoms/Button';
import Navigation from '../atoms/Navigation';
import TagsSlider from '../organism/TagsSlider';
import IconBlock from '../moleculs/IconBlock';
const UserPreferences = () => {
  return (
    <div>
      <IconBlock iconName='profileIcon' iconSource=' ' text='User' titleName='username' wrapperName='profileWrapper'/>
      <Navigation text='Skip' navName='skip'/>
      <Title text='Calibrating your taste'/>
      <TagsSlider/>
      <Header header='Select Themes You Love' subheader='You should choose at least 3 themes to set up your recommendation'/>
      <Button text='Continue'/>
    </div>
  )
}

export default UserPreferences
