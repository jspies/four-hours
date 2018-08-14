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

class Short extends React.Component {
  render() {
    return (
      <View>
        <Text style={[styles.text, styles.headerText]}>LORD'S PRAYER</Text>
        <Text style={styles.text}>Our Father, who art in heaven,</Text>
        <Text style={[styles.text, styles.indentOne]}>hallowed be thy Name,</Text>
        <Text style={[styles.text, styles.indentOne]}>thy kingdom come,</Text>
        <Text style={[styles.text, styles.indentOne]}>thy will be done,</Text>
        <Text style={[styles.text, styles.indentTwo]}>on earth as it is in heaven.</Text>
      </View>
    )
  }
}

module.exports = Short;