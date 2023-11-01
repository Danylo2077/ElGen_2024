import React from 'react'
import './styles/UserPreferences.css';
import UserProfile from './UserProfile';
import Skip from './Skip';
import UserPreferencesHeader from './UserPreferencesHeader';
import TagsSlider from './TagsSlider'
import SubHeader from './SubHeader';
import ContinueBtn from './ContinueBtn';
const UserPreferences = () => {
  return (
    <div>
      <UserProfile/>
      <Skip/>
      <UserPreferencesHeader/>
      <TagsSlider/>
      <SubHeader/>
      <ContinueBtn/>
    </div>
  )
}

export default UserPreferences
