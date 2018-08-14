/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  StyleSheet,
  Text,
  Button,
  AppState,
  Linking,
  View,
  NativeModules,
  DeviceEventEmitter
} from 'react-native';

import { createStackNavigator } from 'react-navigation';
import NavigationService from './services/navigationService';
import Short from './components/short';

class HomeScreen extends Component {
  static navigationOptions = {
    headerTitle: "Four Hours",
    headerRight: (
      <Button
        onPress={() => alert('This is a button!')}
        title="Info"
        color="#fff"
      />
    ),
    drawerLabel: 'Home',
    drawerIcon: ({ tintColor }) => (
      <Image
        source={require('./chat_icon.png')}
        style={[styles.icon, {tintColor: tintColor}]}
      />
    ),
  };

  constructor() {
    super();
    AppState.addEventListener('change', this._handleAppStateChange.bind(this));
    DeviceEventEmitter.addListener('shortIntent', this.shortIntent);
  }

  _handleAppStateChange(event) {
    Linking.getInitialURL()
    .then((url) => {
      console.log("url is ", url)
    })
  }
  

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Four Hours. You should get an alarm notification soon.
        </Text>
        
      </View>
    );
  }

  shortIntent() {
    console.log("lllllllddkdddkdkdkd");
    NavigationService.navigate('Short');
  } 

  componentWillMount() {
    NativeModules.FHNotifications.createNotificationChannel();
    
    NativeModules.Alarms.setAlarm("MORNING", 7, 30, (err, response) => {
      console.log(response)
    });

    NativeModules.Alarms.setAlarm("NOONDAY", 10, 26, (err, response) => {
      console.log(response)
    });

    NativeModules.Alarms.setAlarm("COMPLINE", 22, 30, (err, response) => {
      console.log(response)
    });
  }

  _handleOpenURL(event) {
    console.log("URL", event.url)
  }

}

const RootStack = createStackNavigator({
  Home: {
    screen: HomeScreen
  },
  Short: {
    screen: Short
  }
}, {
  initialRouteName: 'Home'
});

export default class App extends Component {

  render() {
    return <RootStack/>;
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  icon: {
    width: 24,
    height: 24,
  },
});
