// import type {ViewProps} from 'ViewPropTypes';
import React from 'react'
import type {HostComponent, ViewProps} from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

type Float = number;

export interface NativeProps extends ViewProps {
  fragmentShader?: string;
  vertexShader?: string;
  points?: Float[];


  //GL props
  glLineWidth: Float;
  glPointSize: Float;
  // onShaderLoaded?: (...args: any[]) => Promise<void>;
  // add other props here
}

export default codegenNativeComponent<NativeProps>(
  'RNGLLIB',
) as HostComponent<NativeProps>;