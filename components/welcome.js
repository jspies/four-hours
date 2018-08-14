/** 
 * The Lord's Prayer Text snippet
 * 
 * TODO: Add option to customize traditional or modern language.
*/

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

class Welcome extends React.Component {
  render() {
    return (
      <View>
        <Text style={[styles.text, styles.headerText]}>FOUR HOURS</Text>
        
        <Text style={[styles.text, styles.indentOne]}>
          This app will send you notifications during the day. One for each of the four hours.
        </Text>
        <Text style={[styles.text, styles.indentTwo]}>Morning Prayer</Text>
        <Text style={[styles.text, styles.indentTwo]}>Noon Prayer</Text>
        <Text style={[styles.text, styles.indentTwo]}>Evening Prayer</Text>
        <Text style={[styles.text, styles.indentTwo]}>Compline</Text>

      </View>
    )
  }
}

module.exports = Welcome;