/**
 * That class defines the structure of a pair shader, where the first element of the tuple is the vertex shader and the second element is the fragment shader
 */
class ShaderPair {
  private pair: [string, string];

  constructor (vertexShader: string, fragmentShader: string) {
    this.pair = [vertexShader, fragmentShader]
  }

  getPair(): [string, string] {
    return this.pair;
  }
}