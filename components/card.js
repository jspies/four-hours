import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

const styles = StyleSheet.create({
  wrapper: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center'
  },
  card: {
    backgroundColor: 'rgb(96,183,125)',
    borderWidth: 0,
    width: 360,
    height: 300,
    padding: 10
  },
  header: {
    height: 30
  }
})

export default class Card extends React.Component {
  render () {
    return (
      <View style={styles.wrapper}>
        <View style={styles.card}>
          {this.props.children}
        </View>
      </View>
    )
  }
}