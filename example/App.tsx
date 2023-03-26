/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, {useEffect, useState} from 'react';
import type {PropsWithChildren} from 'react';
import {
  Button,
  Dimensions,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import RNGLAppWrapper from 'RNGLLIB/js/NativeRNGLLIBProps';

type SectionProps = PropsWithChildren<{
  title: string;
}>;

function Section({children, title}: SectionProps): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';
  return (
    <View style={styles.sectionContainer}>
      <Text
        style={[
          styles.sectionTitle,
          {
            color: isDarkMode ? Colors.white : Colors.black,
          },
        ]}>
        {title}
      </Text>
      <Text
        style={[
          styles.sectionDescription,
          {
            color: isDarkMode ? Colors.light : Colors.dark,
          },
        ]}>
        {children}
      </Text>
    </View>
  );
}

const RNGLApp = (app: JSX.Element) => {
  return <RNGLAppWrapper>{app}</RNGLAppWrapper>;
};

function App(): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';
  const [count, setCount] = useState(0);

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  function addVal() {
    setCount(count + 1);
  }

  const TxtC = (text: number) => {
    const num = Number(text);

    return (
      <View style={{backgroundColor: num % 2 === 0 ? 'yellow' : 'black'}}>
        <Text>{text}</Text>
      </View>
    );
  };

  const list = () => {
    const arr = [];
    for (let index = 0; index < 50; index++) {
      arr.push(TxtC(index));
    }
    return arr;
  };

  return (
    <SafeAreaView style={{flex: 1}}>
      {/* <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={backgroundStyle.backgroundColor}
      />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
        style={backgroundStyle}>
        <Header />
        <View
          style={{
            backgroundColor: isDarkMode ? Colors.black : Colors.white,
          }}>
          <Section title="Step One">
            Edit <Text style={styles.highlight}>App.tsx</Text> to change this
            screen and then come back to see your edits.
          </Section>
          <Section title="See Your Changes">
            <ReloadInstructions />
          </Section>
          <Section title="Debug">
            <DebugInstructions />
          </Section>
          <Section title="Learn More">
            Read the docs to discover what to do next:
          </Section>
          <LearnMoreLinks />
        </View>
      </ScrollView> */}
      {/* <View> */}
      <RNGLAppWrapper
        style={{flex: 1}}
        fragmentShader={
          'precision mediump float;' +
          'uniform vec4 u_Color;' +
          'void main() {' +
          'gl_FragColor = u_Color;' +
          '}'
        }
        vertexShader={
          'attribute vec4 a_Position;' +
          'void main() {' +
          'gl_Position = a_Position;' +
          '}'
        }
        glLineWidth={count}
        glPointSize={1}>
        <ScrollView>{list()}</ScrollView>
        {/* <Button title="TETS" /> */}
      </RNGLAppWrapper>
      <Button title={`Click ${count}`} onPress={addVal} />
      {/* </View> */}
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default App;
