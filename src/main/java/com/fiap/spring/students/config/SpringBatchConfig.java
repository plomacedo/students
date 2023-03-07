package com.fiap.spring.students.config;
import com.fiap.spring.students.dto.StudentDTO;
import com.fiap.spring.students.entities.Student;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Student> itemReader() {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<Student>();
        reader.setResource( new FileSystemResource( "src/main/resources/lista_alunos.txt" ) );
        reader.setName( "Flat file reader" );
        reader.setLinesToSkip( 1 );
        reader.setLineMapper( lineMapper() );
        return reader;
    }

    @Bean
    public LineMapper<Student> lineMapper() {

        DefaultLineMapper<Student> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter( "  " );
        lineTokenizer.setStrict( false );
        lineTokenizer.setNames( "name", "enrollment" );
        BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType( Student.class );
        defaultLineMapper.setLineTokenizer( lineTokenizer );
        defaultLineMapper.setFieldSetMapper( fieldSetMapper );
        return defaultLineMapper;
    }


    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<Student> itemReader,
                   ItemProcessor<Student, StudentDTO> itemProcessor,
                   ItemWriter<StudentDTO> itemWriter
    ) {
        Step step = stepBuilderFactory.get( "step" )
                    .<Student, StudentDTO>chunk( 10 )
                    .reader(itemReader)
                    .processor(itemProcessor)
                    .writer(itemWriter)
                    .build();

            return jobBuilderFactory.get( "step2" )
                    .incrementer( new RunIdIncrementer() )
                    .start( step )
                    .build();
        }


}
