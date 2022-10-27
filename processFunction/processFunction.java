import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction.Context;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction.OnTimerContext;
import org.apache.flink.util.Collector;

//Source data to a stream 
DataStream<Tuple2<String,String>>stream=...;

DataStream<Tuple2<String,Long>>result=stream.keyBy(value->value.f0).process(new CountWithTimeoutFunction());

public class CountWithTimeStamp {
    public String key;
    public long count;
    public long lastModified;
}

public class CountWithTimeoutFunction
        extends KeyedProcessFunction<Tuple, Tuple2<String, String>, Tuple2<String, Long>> {
    private ValueState<CountWithTimeStamp> state;

}