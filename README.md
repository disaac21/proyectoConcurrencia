# proyectoConcurrenciaDataset

**Link Dataset Original**
**Buscar en archivo linkDataset.txt**

## Instrucciones para Ejecucion

### IMPORTANTE
### Descargar datasetCompleto.txt

### Este archivo se encontrara en el drive que se encuentra en el archivo linkDataset.txt.
### El uso del archivo txt es obligatorio ya que es el que usamos para el desarrollo del proyecto.

**Si desea utilizar el archivo datasetCompleto.csv descargado de Kaggle o del Drive, debera convertir el archivo datasetCompleto.csv a txt mediante el uso del programa preparingDataset.py.**

- Para esto, debera descargar datasetCompleto.csv y guardar el archivo en el mismo folder donde se encuentra preparingDataset.py

### NECESARIO
- Una vez tenga datasetCompleto.txt, este archivo se debe de ubicar en el directorio workingFiles.

## El diccionario se encuentra en el directorio workingFiles, con nombre Dictionary.txt

## Preprocesamiento

- Para el preprocesamiento se utiliza el archivo preProcesamiento.java

**COMPILAR**
- javac preProcesamiento.java

**Correr**
- java preProcesamiento //(usa el .class)

- Luego de preprocesar, se genera el archivo datasetProcesado.txt, el cual se guarda en el directorio Working Files.

**IMPORTANTE**
**Un archivo datasetProcesado.txt se encuentra en el drive, con el mismo nombre. Drive se encuentra en archivo linkDataset.txt**

## WordCount

**Para trabajar con Hadoop, se utilizan archivos jar. .Jar para WordCount de conjutnos de 1 palabra se encuentra en carpeta FrecuencyAnalysis1.  .Jar para WordCount de conjuntos de 2 palabras se encuentra en carpeta FrecuencyAnalysis2**

primero instalar hadoop

dentro de hadoop, crear una carpeta para nuestro input, aca vamos a alojar nuestro dataset procesado

hdfs dfs -mkdir /ruta_de_la_carpeta_input/

luego metemos nuestro dataseta en hadoop, lo haremos en esa carpeta que acabamos de crear

hdfs dfs -put /ruta_del_dataset/ /ruta_de_la_carpeta_input/

## wordcount frecuencia de 1

### Si desea obtener el archivo part-r-00000 para conjuntos de 1 palabra, podra encontrarlo en el drive en un folder llamado ArchivosGeneradosHadoopWordCount1

- entrar a la carpeta Frequency1 del repositorio

hadoop jar wordcount.jar WordCount /ruta_de_carpeta_input_en_hadoop/ /ruta_destino_dentro_de_hadoop/

- la carpeta destino se crea al momento de correr este comando, se pide que sea una ruta nueva, es decir, no usar una carpeta ya existente para alojar el output, el comando deberia de crear una carpeta nueva.
- hadoop en esta carpeta guardara dos archivos, unos llamado ‘_SUCCESS’ y otro llamado ‘part-r-00000’ a nosotros nos interesa el archivo part-r-00000 porque es donde tenemos las palabras y las veces que se repiten.
- este archivo debemos traerlo a local y guardarlo en la carpeta Frequency1 del repositorio
- ya que ya estamos en la carpeta Frequency1 del repositorio corremos el siguiente comando para traer ese part-r-00000 a nuestra carpeta local:

hdfs dfs -get /ruta_del_part-r-00000_en_hadoop/ .

como ruta destino ponemos el ‘.’ si ya estamos en la carpeta Frequency1 del repositorio, si estamos desde otra carpeta, usamos esta alternativa:

hdfs dfs -get /ruta_del_part-r-00000_en_hadoop/ /ruta_de_la_carpeta_Frequency1_del_repositorio/

dentro de la carpeta Frequency1 corremos el archivo de python freq-analysis.py, este archivo generara el archivo freq-results-sorted.txt el cual es nuestro archivo final.

asegurese que el archivo part-r-00000 este en la misma carpeta que el archivo freq-analysis.py

## wordcount frecuencia de 2

### Si desea obtener el archivo part-r-00000 para conjuntos de 2 palabras, podra encontrarlo en el drive en un folder llamado ArchivosGeneradosHadoopWordCount2

- entrar a la carpeta Frequency2 del repositorio

hadoop jar wordcount2.jar WordCount2 /ruta_de_carpeta_input/ /ruta_destino_dentro_de_hadoop/

- la carpeta destino se crea al momento de correr este comando, se pide que sea una ruta nueva, es decir, no usar una carpeta ya existente para alojar el output, el comando deberia de crear una carpeta nueva.
- hadoop en esta carpeta guardara dos archivos, unos llamado ‘_SUCCESS’ y otro llamado ‘part-r-00000’ a nosotros nos interesa el archivo part-r-00000 porque es donde tenemos las palabras y las veces que se repiten.
- este archivo debemos traerlo a local y guardarlo en la carpeta Frequency2 del repositorio
- ya que ya estamos en la carpeta Frequency2 del repositorio corremos el siguiente comando para traer ese part-r-00000 a nuestra carpeta local:

hdfs dfs -get /ruta_del_part-r-00000_en_hadoop/ .

como ruta destino ponemos el ‘.’ si ya estamos en la carpeta Frequency2 del repositorio, si estamos desde otra carpeta, usamos esta alternativa:

hdfs dfs -get /ruta_del_part-r-00000_en_hadoop/ /ruta_de_la_carpeta_Frequency2_del_repositorio/

dentro de la carpeta Frequency2 corremos el archivo de python freq-analysis2.py, este archivo generara el archivo freq-results-sorted.txt el cual es nuestro archivo final.

asegurese que el archivo part-r-00000 este en la misma carpeta que el archivo freq-analysis2.py