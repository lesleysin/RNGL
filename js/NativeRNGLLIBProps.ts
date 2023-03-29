import React from 'react'
import type {HostComponent, ViewProps} from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

//NOTE - react native codegen require define number-based type as Float, Int32 or Double

export interface NativeProps extends ViewProps {
  /**
   * Defines an array of vertex values ​​for graphics primitives
   */
  points: Float[];

  /**
   * @class located in RNGLLIB/js/types/ShaderPair.ts
   */
  shaderPair: string[];

  /**
   * Determines whether the body of the onDrawFrame function will be executed
   */
  active: boolean;

  glLineWidth?: Float;
  glPointSize?: Float;
}

export default codegenNativeComponent<NativeProps>(
  'RNGLLIB',
) as HostComponent<NativeProps>;