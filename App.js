import { NativeModules } from 'react-native';
import React, { useEffect } from 'react';
import { Text, View } from 'react-native';
const { BBDDConnect } = NativeModules;

const App = () => {
  useEffect(() => {
    BBDDConnect.conectarAsync()
      .then((result) => {
        console.log(result); // "Conexión exitosa"
      })
      .catch((error) => {
        console.error("Error de conexion",error.message);
      });
  }, []); // El array vacío asegura que esto se ejecute solo una vez al montar el componente

  return (
    <View>
      <Text>Hola mundo</Text>
    </View>
  );
}

export default App;
