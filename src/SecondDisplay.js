import React from "react";
import { StyleSheet, Text, View } from "react-native";

const SecondDisplay = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.hello}>Hello from presentor screen</Text>
    </View>
  );
};

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    backgroundColor: "#f0f0f0",
  },
  hello: {
    fontSize: 20,
    textAlign: "center",
    margin: 10,
  },
});

export default SecondDisplay;
