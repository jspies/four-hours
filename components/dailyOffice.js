
import React from 'react';
import { Text, StyleSheet, View } from 'react-native';

let styles = StyleSheet.create({
  text: {
    color: 'white',
    fontSize: 20
  },
  indentOne: {
    paddingLeft: 20
  },
  indentTwo: {
    paddingLeft: 40
  },
  headerText: {
    fontSize: 18,
    marginBottom: 20
  }
});

class DailyOffice extends React.Component {
  render() {
    return (
      <View>
        <Text>Psalm 89:1-18</Text>
        <Text>Num 14:26-45</Text>
      </View>
    )
  }
}

module.exports = DailyOffice;