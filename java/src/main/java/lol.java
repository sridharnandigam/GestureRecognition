import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.common.io.ClassPathResource;
import org.nd4j.evaluation.classification.Evaluation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class lol {

    private static Logger log = LoggerFactory.getLogger(lol.class);

    public static void main(String[] args) throws Exception {

        String simpleMlp = new ClassPathResource("full_model.h5").getFile().getPath();
        MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp);;
        int numLinesToSkip = 0;
        String delimiter = ",";
        RecordReader recordReader = new CSVRecordReader(numLinesToSkip,delimiter);
        recordReader.initialize(new FileSplit(new ClassPathResource("javatest.csv").getFile()));

        ///System.out.print(model.conf().toJson());

        //label index
        int labelIndex = 3; //5th field
        //num of classes
        int numClasses = 11;
        //batchsize all
        int batchSize = 1;

        DataSetIterator iterator = new RecordReaderDataSetIterator(recordReader,batchSize,labelIndex,numClasses);

        DataSet allData = iterator.next();
        allData.shuffle();
        //have model
        //read model
        //evalulate

        Evaluation eval = new Evaluation(11);
        INDArray output = model.output(allData.getFeatures());
        eval.eval(allData.getLabels(),output);
        log.info(eval.stats());
    }
}


